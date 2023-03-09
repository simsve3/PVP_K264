import './App.css';
import { BrowserRouter as Router, Route, Routes} from "react-router-dom";

import Home from "./Pages/Home.js"
import TestPage1 from "./Pages/TestPage1.js";
import TestPage2 from "./Pages/TestPage2.js";

function App() {
  return (
    <Router>
        <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/TestPage1" element={<TestPage1 />}/>
            <Route path="/TestPage2" element={<TestPage2 />}/>
        </Routes>
    </Router>
  );
}
export default App;
