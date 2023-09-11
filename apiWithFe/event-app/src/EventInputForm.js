import React, { useState } from 'react';
import axios from 'axios';

import { ToastContainer, toast } from 'react-toastify';

const EventInputForm = () => {
  const [eventText, setEventText] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post('http://localhost:8080/api/events', {
        text: eventText,
      });
      setEventText('');
      toast.success('Event created successfully!');
    } catch (error) {
      toast.error('Error creating event.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Event:
        <input
          type="text"
          value={eventText}
          onChange={(e) => setEventText(e.target.value)}
        />
      </label>
      <button type="submit">Create Event</button>
    </form>
  );
};

export default EventInputForm;
