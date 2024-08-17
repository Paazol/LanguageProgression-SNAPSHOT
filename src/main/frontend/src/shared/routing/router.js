import React from 'react';
import ReactDOM from "react-dom/client";
import {createBrowserRouter, RouterProvider} from "react-router-dom";

function createRouter(path) {
    const router = createBrowserRouter([
        {
            path: path,
        }
    ]);

    ReactDOM.createRoot(document.getElementById("root")).render(
        <React.StrictMode>
            <RouterProvider router={path} />
        </React.StrictMode>
    );
}


