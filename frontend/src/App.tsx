import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import AnimatedEntry from "./components/canvas/AnimatedEntry";

import "./index.css";

function App() {
    return (
        <div className="flex min-h-svh items-center justify-center px-6">
            <AnimatedEntry />
        </div>
    );
}

const root = document.getElementById("root");

if (!root) {
    throw new Error("Root element not found");
}

createRoot(root).render(
    <StrictMode>
        <App />
    </StrictMode>,
);

export default App;
