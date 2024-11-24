import { routerType } from "./router.types";
import Login from "../../pages/login/login.tsx";
import Home from "../../pages/home/home.tsx";
import Register from "../../pages/register/register.tsx";
import Profile from "../../pages/profile/profile.tsx";

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
    },
    {
        path: "/profile",
        title: "profile",
        element: <Profile/>
    }
];

export default pagesData;
