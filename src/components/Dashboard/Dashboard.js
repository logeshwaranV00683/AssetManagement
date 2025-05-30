import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import {  PieChart,  Pie,  Cell,  ResponsiveContainer,  Tooltip,  Legend,} from 'recharts';
import {  Container,  Card,  CardContent,  Typography,  Box,  TextField,  MenuItem,  Select,  FormControl,  InputLabel,} from '@mui/material';
import { DataGrid } from '@mui/x-data-grid';
import '../Style/font.css';

const useStyles = makeStyles((theme) => ({
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
    fontFamily: "'Racing Sans One', sans-serif",
  },
  pieContainer: {
    display: 'flex',
    justifyContent: 'space-around',
    alignItems: 'center',
    marginTop: theme.spacing(3),
    marginLeft: '25px',
    flexWrap: 'wrap',
    gap: '20px',
  },
  pieCard: {
    width: '45%',
    fontFamily: "'Racing Sans One', sans-serif",
  },
  label: {
    textAlign: 'center',
    color: 'grey',
    marginTop: theme.spacing(2),
    fontFamily: "'Racing Sans One', sans-serif",
  },
}));

function Dashboard() {
  const classes = useStyles();

  const [selectedDevice, setSelectedDevice] = useState('Laptop');
  const [filterValue, setFilterValue] = useState('');
  const [filteredRows, setFilteredRows] = useState([
    { id: 1, assetName: 'Laptop', serialNumber: 'SN001', location: 'Room A', model: 'Model X', assign: 'Assign X' },
    { id: 2, assetName: 'Desktop', serialNumber: 'SN002', location: 'Room B', model: 'Model Y', assign: 'Assign Y' },
    { id: 3, assetName: 'Printer', serialNumber: 'SN003', location: 'Room C', model: 'Model Z', assign: 'Assign Z' },
  ]);

  const rows = filteredRows;

  const deviceData = {
    Laptop: {
      chennai: [{ name: 'Stock', value: 23 }, { name: 'Assigned', value: 104 }],
      pune: [{ name: 'Stock', value: 26 }, { name: 'Assigned', value: 146 }],
    },
    Mouse: {
      chennai: [{ name: 'Stock', value: 45 }, { name: 'Assigned', value: 80 }],
      pune: [{ name: 'Stock', value: 30 }, { name: 'Assigned', value: 110 }],
    },
    Keyboard: {
      chennai: [{ name: 'Stock', value: 40 }, { name: 'Assigned', value: 90 }],
      pune: [{ name: 'Stock', value: 35 }, { name: 'Assigned', value: 100 }],
    },
    Headset: {
      chennai: [{ name: 'Stock', value: 20 }, { name: 'Assigned', value: 70 }],
      pune: [{ name: 'Stock', value: 25 }, { name: 'Assigned', value: 95 }],
    },
  };

  const data = deviceData[selectedDevice].chennai;
  const data2 = deviceData[selectedDevice].pune;
  const COLORS = ['#00e0ff', '#f72585'];

  const columns = [
    { field: 'id', headerName: 'ID', width: 90, headerClassName: 'racing-font' },
    { field: 'assetName', headerName: 'Asset name', width: 200, headerClassName: 'racing-font' },
    { field: 'serialNumber', headerName: 'Serial Number', width: 200, headerClassName: 'racing-font' },
    { field: 'location', headerName: 'Location', width: 150, headerClassName: 'racing-font' },
    { field: 'model', headerName: 'MODL', width: 150, headerClassName: 'racing-font' },
    { field: 'assign', headerName: 'ASSIGN', width: 150, headerClassName: 'racing-font' },
  ];

  const handleSearch = (event) => {
    const value = event.target.value.toLowerCase();
    setFilterValue(value);
    const filtered = rows.filter(
      (row) =>
        row.assetName.toLowerCase().includes(value) ||
        row.serialNumber.toLowerCase().includes(value) ||
        row.location.toLowerCase().includes(value) ||
        row.model.toLowerCase().includes(value) ||
        row.assign.toLowerCase().includes(value)
    );
    setFilteredRows(filtered);
  };

  return (
    <div>
      <main className={classes.content}>
        <Container maxWidth="lg" style={{ fontFamily: "'Racing Sans One', sans-serif" }}>
          <div className={classes.pieContainer}>


            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', flexWrap: 'wrap', gap: '30px', marginTop: '10px' }}>
              {/* Pie Chart - Chennai */}
              <Card className={classes.pieCard} style={{ flex: 1, minWidth: '280px', background: 'transparent', boxShadow: 'none' }}>
                <CardContent>
                  <div className={classes.label} style={{margin: '20px',  }}>
                    <Typography variant="h6" style={{ color: '#00f0ff', textShadow: '0 0 6px #2BC4F3', letterSpacing: '1.5px' }}>
                      {selectedDevice}: {data[0].value}/{data[1].value}
                    </Typography>
                    <Typography variant="h6" style={{ color: '#00f0ff', textShadow: '0 0 6px #2BC4F3', letterSpacing: '1.5px' }}>
                      CHENNAI
                    </Typography>
                  </div>
                  <div style={{ height: 250, width: '100%' }}>
                    <ResponsiveContainer width="100%" height={260}>
                      <PieChart>
                        <Pie dataKey="value" data={data} cx="50%" cy="50%" outerRadius={100} label>
                          {data.map((entry, index) => (
                            <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} style={{ filter: 'drop-shadow(0 0 10px rgba(0, 240, 255, 0.8))' }} />
                          ))}
                        </Pie>
                        <Tooltip contentStyle={{ backgroundColor: '#0d1b2a', border: '1px solid #00f0ff', color: '#ffffff' }} itemStyle={{ color: '#00f0ff' }} />
                        <Legend wrapperStyle={{ color: '#00f0ff', textShadow: '0 0 4px #00f0ff' }} />
                      </PieChart>
                    </ResponsiveContainer>
                  </div>
                </CardContent>
              </Card>

              {/* Dropdown */}
              <Box sx={{ width: 150, display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '80px' }}>
                <FormControl variant="outlined" style={{ width: 150 }}>
                  <InputLabel style={{ fontFamily: "'Racing Sans One', sans-serif" }}>Device</InputLabel>
                  <Select
                    value={selectedDevice}
                    onChange={(e) => setSelectedDevice(e.target.value)}
                    label="Device"
                    sx={{
                      fontFamily: "'Racing Sans One', sans-serif",
                      background: '#ffffff',
                      borderRadius: '12px',
                      boxShadow: '0 0 8px rgba(0, 240, 255, 0.4)',
                      color: '#083A40',
                    }}
                  >
                    {Object.keys(deviceData).map((device) => (
                      <MenuItem key={device} value={device}>
                        {device}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>

              </Box>

              {/* Pie Chart - Pune */}
              <Card className={classes.pieCard} style={{ flex: 1, minWidth: '280px', background: 'transparent', boxShadow: 'none' }}>
                <CardContent>
                  <div className={classes.label} style={{margin: '20px', }}>
                    <Typography variant="h6" style={{ color: '#00f0ff', textShadow: '0 0 6px #2BC4F3', letterSpacing: '1.5px' }}>
                      {selectedDevice}: {data2[0].value}/{data2[1].value}
                    </Typography>
                    <Typography variant="h6" style={{ color: '#00f0ff', textShadow: '0 0 6px #2BC4F3', letterSpacing: '1.5px' }}>
                      PUNE
                    </Typography>
                  </div>
                  <div style={{ height: 250, width: '100%' }}>
                    <ResponsiveContainer width="100%" height={260}>
                      <PieChart>
                        <Pie dataKey="value" data={data2} cx="50%" cy="50%" outerRadius={100} label>
                          {data2.map((entry, index) => (
                            <Cell key={`cell2-${index}`} fill={COLORS[index % COLORS.length]} style={{ filter: 'drop-shadow(0 0 5px rgba(0, 240, 255, 0.9))' }} />
                          ))}
                        </Pie>
                        <Tooltip contentStyle={{ backgroundColor: '#0d1b2a', border: '1px solid #00f0ff', color: '#ffffff' }} itemStyle={{ color: '#00f0ff' }} />
                        <Legend wrapperStyle={{ color: '#00f0ff', textShadow: '0 0 1px #00f0ff' }} />
                      </PieChart>
                    </ResponsiveContainer>
                  </div>
                </CardContent>
              </Card>
            </div>

          </div>

          {/* Search & DataGrid */}
          <div style={{ height: 400, width: '100%', display: 'flex', marginTop: '50px', flexDirection: 'column', alignItems: 'center' }}>
            <Box mb={1}>
              <TextField
                label="Search"
                variant="outlined"
                onChange={handleSearch}
                value={filterValue}
                sx={{
                  width: { xs: '100%', md: '85vw' },
                  maxWidth: '1000px',
                  '& .MuiOutlinedInput-root': {
                    background: '#ffffff',
                    borderRadius: '15px',
                    color: '#083A40',
                    fontWeight: 500,
                    boxShadow: '0 0 6px rgba(255, 255, 255, 0.8), 0 0 12px rgba(109, 224, 255, 0.6)',
                    '& fieldset': { border: '0.5px solid transparent' },
                    '&:hover fieldset': { border: '0.5px solid #1FCBEA' },
                    '&.Mui-focused fieldset': {
                      boxShadow: '0 0 6px rgba(255, 255, 255, 0.8), 0 0 12px rgba(109, 224, 255, 0.6)',
                      fontSize: '20px',
                    },
                    '& input': {
                      background: 'transparent',
                      color: '#083A40',
                      fontFamily: "'Racing Sans One', sans-serif",
                    },
                  },
                  '& .MuiInputLabel-root': {
                    color: '#083A40',
                    fontFamily: "'Racing Sans One', sans-serif",
                    letterSpacing: '2.0px',
                  },
                  '& .Mui-focused .MuiInputLabel-root': {
                    color: '#083A40',
                  },
                }}
              />
            </Box>

            <div style={{ height: '65vh', width: '85vw', display: 'flex', flexDirection: 'column', alignItems: 'center', marginTop: '50px' }}>
              <div style={{ height: 350, marginLeft: '2%', width: '95%', flexGrow: 1 }}>
                <DataGrid
                  rows={filteredRows}
                  columns={columns}
                  pageSize={5}
                  rowsPerPageOptions={[5, 10, 20]}
                  sx={{
                    borderRadius: '16px',
                    overflow: 'hidden',
                    border: '2px solid #1FCBEA',
                    boxShadow: '0 0 3px #6DE0FF, 0 0 4px #2BC4F3',
                    fontFamily: "'Racing Sans One', sans-serif",
                    color: '#083A40',
                    '& .MuiDataGrid-columnHeaders': {
                      background: 'linear-gradient(45deg, #6DE0FF, #2BC4F3)',
                      color: '#083A40',
                      fontSize: '16px',
                      fontWeight: 700,
                    },
                    '& .MuiDataGrid-cell': {
                      background: '#F0FBFF',
                      color: '#083A40',
                      fontSize: '15px',
                      borderBottom: '1px solid #D0F0FF',
                    },
                    '& .MuiDataGrid-footerContainer': {
                      background: 'linear-gradient(45deg, #6DE0FF, #2BC4F3)',
                      color: '#083A40',
                      fontWeight: 600,
                    },
                    '& .MuiDataGrid-row:hover': {
                      backgroundColor: '#E0F9FF',
                    },
                    '& .MuiDataGrid-selectedRowCount': {
                      color: '#083A40',
                    },
                    '& .MuiCheckbox-root': {
                      color: '#083A40',
                    },
                  }}
                />
              </div>
            </div>
          </div>
        </Container>
      </main>
    </div>
  );
}

export default Dashboard;
