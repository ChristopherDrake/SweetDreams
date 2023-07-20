import React, {useState, useEffect, useContext} from 'react';
import { Link } from 'react-router-dom';
import { auth } from '../services/firebase';
import './Navbar.css';

function NavigationBar() {
  const [loggedIn, setLoggedIn] = useState(false);
  const { totalItems } = useContext(CartContext);

  useEffect(() => {
    const unsubscribe = auth.onAuthStateChanged((user) => {
      setLoggedIn(user ? true : false);
    });

    return () => {
      unsubscribe();
    };
  }, []);

  return (
    <nav className="navbar">
      <ul className="navbar-nav">
        <li className="nav-item">
          <Link to="/" className="nav-link">
            Home
          </Link>
        </li>
        {!loggedIn && (
        <>
          <li className="nav-item">
            <Link to="/login" className="nav-link">
              Log In
            </Link>
          </li>
          <li className="nav-item">
            <Link to="/sign-up" className="nav-link">
              Sign Up
            </Link>
          </li>
        </>
      )}
        <li>
          <Link to="/account" className="nav-link">
            Account
          </Link>
        </li>
      </ul>
    </nav>
  );
}

export default NavigationBar;
