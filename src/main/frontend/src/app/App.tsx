import { BrowserRouter } from "react-router-dom";
import Router from "./routing/router.tsx";

const App = () => {
    return (
        <BrowserRouter>
            <Router />
        </BrowserRouter>
    );
};

export default App;