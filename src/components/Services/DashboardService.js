import axios from 'axios';
const token = localStorage.getItem('authToken');
const apiUrl = process.env.REACT_APP_API_URL;


export const getAssetsByLocation = async (location) => {
  const url = `${apiUrl}/assetManager/v1/AssetCount/location?location=${encodeURIComponent(location)}`;

  try {
    const response = await fetch(url, {
      method: 'GET',
      headers: {
       'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
    });

    const data = await response.json();

    if (!data || typeof data !== 'object') {
      console.error('Invalid response structure:', data);
      return {};
    }

    return data;

  } catch (error) {
    console.error('Error fetching assets:', error);
    return {};
  }
};

export const getUnassignedAssetsByLocation = async (location) => {
  const url = `${apiUrl}/assetManager/v1/AssetCount/unAssigned?location=${encodeURIComponent(location)}`;

  try {
    const response = await fetch(url, {
      method: 'GET',
      headers: {
       'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
    });

    const data = await response.json();

    if (!data || typeof data !== 'object') {
      console.error('Invalid response structure:', data);
      return {};
    }

    return data;

  } catch (error) {
    console.error('Error fetching assets:', error);
    return {};
  }
};

export const getAssignedAssetsByLocation = async (location) => {
  const url = `${apiUrl}/assetManager/v1/AssetCount/assigned?location=${encodeURIComponent(location)}`;

  try {
    const response = await fetch(url, {
      method: 'GET',
      headers: {
       'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
    });

    const data = await response.json();

    if (!data || typeof data !== 'object') {
      console.error('Invalid response structure:', data);
      return {};
    }

    return data;

  } catch (error) {
    console.error('Error fetching assets:', error);
    return {};
  }
};


export const getAssignedCountByLocation = async (location) => {
  try {
    const response = await axios.get(`/assetManager/v1/Assetcount/assigned/${location}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching assigned count:', error);
    throw error;
  }
};

export const getUnassignedCountByLocation = async (loc) => {
  try {
    const res = await axios.get(`/assetManager/v1/unassignedCount?location=${loc}`);
    return res.data;
  } catch (error) {
    console.error('Error fetching unassigned count:', error);
    return 0;
  }
};

export const getCountsByLocation = async (location) => {
  try {
    const response = await axios.get(`/assetManager/v1/Assetcount/location/${location}`);
    return response.data; // Map<String, Integer>
  } catch (error) {
    console.error('Error fetching counts by location:', error);
    return {};
  }
};
