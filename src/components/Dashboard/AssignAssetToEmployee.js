import React, { useEffect, useState } from "react";
import {
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  Checkbox,
  ListItemText,
  OutlinedInput,
  Menu,
  Button,
  Box,
} from "@mui/material";
import { getAssetList, assignAsset } from "../Services/AssetService";
import {
  showErrorAlert,
  showSuccessAlert,
  showWarningAlert,
} from "../Utils/alerts";

function AssignAssetToEmployee({ open, onClose, employee, refresh }) {
  const [assets, setAssets] = useState([]);
  const [selectedAssets, setSelectedAssets] = useState([]);
  const [confirmedAssets, setConfirmedAssets] = useState([]);
  const [menuOpen, setMenuOpen] = useState(false);
  const [anchorEl, setAnchorEl] = useState(null);

  useEffect(() => {
    if (open) {
      getAssetList()
        .then((data) => {
          const unassigned = data.filter(
            (asset) => asset.status.toLowerCase() === "unassigned"
          );
          setAssets(unassigned);
        })
        .catch(() =>
          showErrorAlert(
            "Failed to fetch assets",
            "An error occurred while loading assets."
          )
        );
    }
  }, [open]);

  const handleSelectClick = (event) => {
    setAnchorEl(event.currentTarget);
    setMenuOpen(true);
  };

  const handleOkClick = () => {
    if (selectedAssets.length === 0) {
      showWarningAlert("No assets selected", "Please select at least one.");
      return;
    }
    setConfirmedAssets([...selectedAssets]);
    setMenuOpen(false);
  };

  const handleAssign = async () => {
    const user = JSON.parse(localStorage.getItem("user"));
    const assetData = confirmedAssets.map((serialNumber) => {
      const asset = assets.find((a) => a.serialNumber === serialNumber);
      return {
        empId: employee.empId,
        serialNumber,
        assetName: asset?.assetName || "",
        assignedDate: new Date().toISOString(),
        assignedBy: user?.empId || "admin",
      };
    });

    try {
      const result = await assignAsset(assetData);
      showSuccessAlert("Assets Assigned!", result || "Success");
      setSelectedAssets([]);
      setConfirmedAssets([]);
      onClose();
      refresh();
    } catch (error) {
      if (error.status === 406) {
        showWarningAlert("Asset Already Assigned", "Some assets are already assigned.");
      } else {
        showErrorAlert("Assignment Failed", "Could not assign assets.");
      }
    }
  };

  return (
    open && (
      <div className="import-3d-overlay animate__animated animate__fadeIn">
        <div className="import-3d-modal animate__animated animate__zoomIn">
          <button className="import-3d-close" onClick={onClose}>
            &times;
          </button>

          <div className="import-3d-title">
            Assign Assets to {employee?.name}
          </div>

          <div className="import-3d-file-wrapper">
            <FormControl fullWidth>
              <InputLabel>Select Assets</InputLabel>
              <OutlinedInput
                readOnly
                value={selectedAssets.join(", ")}
                onClick={handleSelectClick}
              />
            </FormControl>

            <Menu
              anchorEl={anchorEl}
              open={menuOpen}
              onClose={() => setMenuOpen(false)}
              PaperProps={{
                style: { width: anchorEl?.clientWidth || 300 },
              }}
            >
              {assets.map((asset) => (
                <MenuItem key={asset.serialNumber}>
                  <Checkbox
                    checked={selectedAssets.includes(asset.serialNumber)}
                    onChange={(e) => {
                      const value = asset.serialNumber;
                      setSelectedAssets((prev) =>
                        e.target.checked
                          ? [...prev, value]
                          : prev.filter((v) => v !== value)
                      );
                    }}
                  />
                  <ListItemText
                    primary={`${asset.serialNumber} - ${asset.assetName}`}
                  />
                </MenuItem>
              ))}

              <Box textAlign="center" p={1}>
                <Button variant="contained" size="small" onClick={handleOkClick}>
                  OK
                </Button>
              </Box>
            </Menu>

            {confirmedAssets.length > 0 && (
              <button className="import-3d-button" onClick={handleAssign}>
                Confirm Assigning
              </button>
            )}
          </div>
        </div>
      </div>
    )
  );
}

export default AssignAssetToEmployee;
