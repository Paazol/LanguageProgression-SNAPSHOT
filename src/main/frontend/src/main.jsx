import React from 'react';
import ReactDOM from "react-dom/client";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import Home from "./pages/home/home.jsx";

const router = createBrowserRouter([
    {
        path: "/home",
        element: <Home />,
    },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>
);