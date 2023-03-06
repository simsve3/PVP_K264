import {Link} from 'react-router-dom'
function Home() {
    return (
        <div>
            <h1>Home page</h1>
            <ul>
                <li>
                    <Link to='/TestPage1'>Test page 1</Link>
                </li>
                <li>
                    <Link to='/TestPage2'>Test page 2</Link>
                </li>
            </ul>
        </div>
    );
  }
  
  export default Home;