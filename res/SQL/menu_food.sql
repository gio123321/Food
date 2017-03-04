CREATE TABLE menu_food (

	id SERIAL PRIMARY KEY,
	menu_id INT REFERENCES menu(id),
	food_id INT REFERENCES food(id)

);