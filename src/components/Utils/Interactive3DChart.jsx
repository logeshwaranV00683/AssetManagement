import React, { useRef, useMemo } from 'react';
import { Canvas, useFrame } from '@react-three/fiber';
import { OrbitControls, Html } from '@react-three/drei';

// A single animated 3D bar
const ChartBar = ({ height, color, label, position }) => {
  const meshRef = useRef();

  useFrame(() => {
    if (meshRef.current) {
      meshRef.current.rotation.y += 0.003; // Continuous rotation
    }
  });

  return (
    <group position={position}>
      <mesh ref={meshRef} position={[0, height / 2, 0]}>
        <boxGeometry args={[1, height, 1]} />
        <meshStandardMaterial color={color} />
      </mesh>
      <Html position={[0, height + 0.4, 0]} center>
        <div style={{ color: '#00f0ff', fontWeight: 'bold', fontSize: '14px' }}>
          {label}
        </div>
      </Html>
    </group>
  );
};

// The full 3D bar chart scene
const ChartScene = ({ data }) => {
  const spacing = 2;
  const colors = useMemo(() => ['#00e0ff', '#f72585', '#ffd166'], []);

  // Generate chart bar positions and colors
  const bars = useMemo(() => {
    return data.map((d, i) => ({
      ...d,
      position: [i * spacing - spacing, 0, 0],
      color: colors[i % colors.length],
    }));
  }, [data, colors]);

  return (
    <Canvas camera={{ position: [0, 5, 10], fov: 50 }} shadows>
      {/* Lighting */}
      <ambientLight intensity={0.5} />
      <spotLight position={[10, 15, 10]} angle={0.3} penumbra={1} castShadow />

      {/* Bars */}
      {bars.map((bar, idx) => (
        <ChartBar
          key={idx}
          height={bar.value / 10}
          color={bar.color}
          label={`${bar.name}: ${bar.value}`}
          position={bar.position}
        />
      ))}

      {/* Camera control */}
      <OrbitControls enableZoom={true} />
    </Canvas>
  );
};

export default ChartScene;
