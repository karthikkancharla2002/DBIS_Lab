INSERT INTO voter (voter_id, name, gender, dob, city, state, address, password) VALUES (1, 'Gowtham', 'Male', '2002-05-31', 'Visakhapatnam', 'Andhra Pradesh', 'Nice place', 'pass');
INSERT INTO voter (voter_id, name, gender, dob, city, state, address, password) VALUES (2, 'Karthik', 'Male', '2002-07-10', 'Hyderbad', 'Telangana', 'VEry Nice palce', 'pass123456');
INSERT INTO voter (voter_id, name, gender, dob, city, state, address, password) VALUES (3, 'Saloni', 'Female', '2001-01-16', 'Nagpur', 'Maharastra', 'Cool Place', '123456');
INSERT INTO voter (voter_id, name, gender, dob, city, state, address, password) VALUES (4, 'T Satwik', 'Male', '2001-08-26', 'Hyderbad', 'Telangana', 'Very good Place', '12345');
INSERT INTO voter (voter_id, name, gender, dob, city, state, address, password) VALUES (5, 'Pranav', 'Male', '2001-04-07', 'Hyderbad', 'Telangana', 'Nice placee', '124');

INSERT INTO positions (position_id, position_name) VALUES (1, 'General Seceratory');
INSERT INTO positions (position_id, position_name) VALUES (2, 'Hostel Seceratory');
INSERT INTO positions (position_id, position_name) VALUES (3, 'CSE CR');
INSERT INTO positions (position_id, position_name) VALUES (4, 'Sports Seceratory');
INSERT INTO positions (position_id, position_name) VALUES (5, 'SMP Seceratory');

INSERT INTO candidate (candidate_id, name, gender, dob, city, state, address, position_id, manifesto) VALUES (1, 'Karthik', 'Male', '2002-07-10', 'Hyderabad', 'Telangana', 'KPHB', 1, 'www.google.com');
INSERT INTO candidate (candidate_id, name, gender, dob, city, state, address, position_id, manifesto) VALUES (2, 'Gowtham', 'Male', '2002-05-31', 'Vizag', 'AP', 'Seetammadhara', 2, 'www.google.com');
INSERT INTO candidate (candidate_id, name, gender, dob, city, state, address, position_id, manifesto) VALUES (3, 'Siba', 'Male', '1984-01-13', 'Dharwad', 'Karnataka', 'IIT Dharwad', 1, 'www.google.com');
INSERT INTO candidate (candidate_id, name, gender, dob, city, state, address, position_id, manifesto) VALUES (4, 'Rajshekar', 'Male', '1980-01-11', 'Dharwad', 'Karnataka', 'IIT Dharwad', 1, 'www.google.com');
INSERT INTO candidate (candidate_id, name, gender, dob, city, state, address, position_id, manifesto) VALUES (5, 'Gayathri', 'Female', '1981-01-15', 'Dharwad', 'Karnataka', 'IIT Dharwad', 2, 'www.google.com');

INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (1, 1, 1);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (2, 2, 4);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (3, 1, 2);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (4, 3, 1);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (5, 2, 3);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (6, 1, 4);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (7, 3, 4);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (8, 5, 1);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (9, 5, 2);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (10, 4, 2);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (11, 4, 3);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (12, 1, 3);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (13, 5, 5);
INSERT INTO canvote (canvote_id, voter_id, position_id) VALUES (14, 3, 5);

INSERT INTO votes (votes_id, candidate_id, canvote_id) VALUES (1, 1, 1);
INSERT INTO votes (votes_id, candidate_id, canvote_id) VALUES (2, 2, 3);
INSERT INTO votes (votes_id, candidate_id, canvote_id) VALUES (3, 1, 4);
INSERT INTO votes (votes_id, candidate_id, canvote_id) VALUES (4, 3, 8);
INSERT INTO votes (votes_id, candidate_id, canvote_id) VALUES (5, 2, 9);

INSERT INTO stage (stage_id, current_stage) VALUES (1, 3);

INSERT INTO admin (admin_id, name, password) VALUES (1, 'Gowtham', 'password');
