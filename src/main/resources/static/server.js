const express = require('express');
const {Pool} = require('pg');
const cors = require('cors');
const path = require('path'); // Import the 'path' module

const app = express();
const port = 3000; // The port your backend server will run on

// --- PostgreSQL Connection Pool Configuration ---
// IMPORTANT: Replace with your actual PostgreSQL credentials and database name
const pool = new Pool({
    user: 'your_username',      // e.g., 'postgres'
    host: 'localhost',
    database: 'brain_tease',    // Your database name
    password: 'your_password',  // Your PostgreSQL password
    port: 5432,                 // Default PostgreSQL port
});

// Test the database connection
pool.connect((err, client, release) => {
    if (err) {
        return console.error('Error acquiring client', err.stack);
    }
    console.log('Successfully connected to PostgreSQL database!');
    release(); // Release the client back to the pool
});

// --- Middleware ---
app.use(cors()); // Enable CORS for all routes (important for API, less so for serving HTML from same origin)
app.use(express.json()); // Enable parsing of JSON request bodies

// --- Serve Static Files ---
// This line tells Express to serve static files (CSS, JS, images)
// from the 'public' directory in your backend folder.
app.use(express.static(path.join(__dirname, 'public')));

// --- API Endpoint to Get Questions (Still needed for the game logic) ---
app.get('/api/questions', async (req, res) => {
    try {
        const result = await pool.query('SELECT id, content, correct_answer FROM question ORDER BY id');
        const questions = result.rows.map(row => ({
            question: row.content,
            answer: row.correct_answer
        }));
        res.json(questions);
    } catch (err) {
        console.error('Error executing query', err.stack);
        res.status(500).json({error: 'Internal server error'});
    }
});

// --- HTML Page Routes ---
// Route for the Main Menu (default path)
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// Route for the Challenges screen
app.get('/challenges', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'challenges.html'));
});

// Route for the Normal Game screen
app.get('/normal-game', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'normal-game.html'));
});

// Route for the Leaderboard Selection screen
app.get('/leaderboards', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'leaderboard-selection.html'));
});

// Route for Normal Mode Leaderboard
app.get('/leaderboards/normal', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'normal-leaderboard.html'));
});

// Route for Speed Challenge Leaderboard
app.get('/leaderboards/speed', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'speed-leaderboard.html'));
});

// Route for the Settings screen
app.get('/settings', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'settings.html'));
});

// --- Start the Server ---
app.listen(port, () => {
    console.log(`Backend server running at http://localhost:${port}`);
    console.log(`Main menu at http://localhost:${port}/`);
    console.log(`Challenges at http://localhost:${port}/challenges`);
    console.log(`Normal Game at http://localhost:${port}/normal-game`);
    console.log(`Leaderboards at http://localhost:${port}/leaderboards`);
    console.log(`Settings at http://localhost:${port}/settings`);
});