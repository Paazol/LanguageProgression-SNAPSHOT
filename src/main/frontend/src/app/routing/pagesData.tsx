import { routerType } from "./router.types";
import Login from "../../pages/login/login.tsx";
import Home from "../../pages/home/home.tsx";
import Register from"../../pages/register/register.tsx";

const pagesData: routerType[] = [
    {
        path: "/home",
        title: "home",
        element: <Home />

    },
    {
        path: "/login",
        title: "login",
        element: <Login />
    },
    {
        path: "/register",
        title: "register",
        element: <Register />
    }
];

export default pagesData;
