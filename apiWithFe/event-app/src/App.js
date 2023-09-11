import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import EventInputForm from './EventInputForm';

const App = () => {
  const [events, setEvents] = useState([]);
  const [eventText, setEventText] = useState('');

  useEffect(() => {
    fetchEvents();
  }, []);

  const fetchEvents = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/events');
      console.log(response)
      setEvents(response.data.events);
    } catch (error) {
      toast.error('Error fetching events from the server.');
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post('http://localhost:8080/api/events', {
        text: eventText,
      });
      setEventText('');
      toast.success('Event created successfully!');
      fetchEvents(); // Refresh the event list after adding a new event
    } catch (error) {
      toast.error('Error creating event.');
    }
  };

  return (
    <div>
      <h1>Event Form</h1>
      <EventInputForm
        eventText={eventText}
        setEventText={setEventText}
        handleSubmit={handleSubmit}
        trigger={fetchEvents}
      />

      <h2>Events List</h2>
      {events.length > 0 ? (
        <ul>
          {events.map((event) => (
            <li key={event.id}>{event.text}</li>
          ))}
        </ul>
      ) : (
        <p>No events found.</p>
      )}

      <ToastContainer />
    </div>
  );
};

export default App;
