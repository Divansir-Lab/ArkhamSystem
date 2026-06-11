import { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import "./index.css";

function App() {
    return (
        <div className="flex min-h-svh items-center justify-center px-6">
            <h1 className="text-4xl font-semibold text-slate-950 dark:text-slate-50">
                Hello world
            </h1>
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
