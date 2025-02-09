import React from 'react';
import './Modal.module.css';
import Button from '../Button';

interface ModalProps {
  title: string;
  message: string;
  onClose: () => void;
}

export const Modal: React.FC<ModalProps> = ({ title, message, onClose }) => {
  return (
    <div style={{ border: '1px solid' }}>
      <h3>{title}</h3>
      <p>{message}</p>
      <Button onClick={onClose}>OK</Button>
    </div>
  );
};
