CREATE TABLE menu_food (

	id SERIAL PRIMARY KEY,
	menu_id REFERENCES menu(id),
	food_id REFERENCES food(id)

);