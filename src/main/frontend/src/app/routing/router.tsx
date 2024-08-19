import { Route, Routes } from "react-router-dom";
import { routerType } from "./router.types";
import pagesData from "./pagesData";

const Router = () => {
    const pageRoutes = pagesData.map(({ path, element }: routerType) => {
        return <Route key={path} path={path} element={element} />;
    });

    return <Routes>{pageRoutes}</Routes>;
};

export default Router;