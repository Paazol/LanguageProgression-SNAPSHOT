import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import Home from './pages/home/home.jsx'
import './pages/home/home.css'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Home />
  </StrictMode>,
)
