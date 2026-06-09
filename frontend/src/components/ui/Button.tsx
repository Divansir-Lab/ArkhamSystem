import React from "react";

interface ButtonProps {
    children: React.ReactNode;
    onClick?: () => void;
}

// s
const Button: React.FC<ButtonProps> = ({ children, onClick }) => {
    return <button onClick={onClick}>{children}</button>;
};

export default Button;
