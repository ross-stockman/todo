import { ReactNode } from 'react';
import styles from './Button.module.css';

interface ButtonProps {
  onClick: () => void;
  children: ReactNode;
}
function Button({ onClick, children }: ButtonProps) {
  return (
    <button className={styles['action-button']} onClick={onClick}>
      {children}
    </button>
  );
}

export default Button;
