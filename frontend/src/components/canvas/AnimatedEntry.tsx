import React from "react";

export default function Logo() {
    return (
        <svg width="200" height="200" viewBox="0 0 200 200">
            <circle
                cx="100"
                cy="100"
                r="80"
                stroke="white"
                strokeWidth="4"
                fill="none"
            />

            <path d="M60 100 L100 60 L140 100 L100 140 Z" fill="#00ff88" />
        </svg>
    );
}
