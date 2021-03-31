# ProblemHelper
All outputs printed on the console, are also copied to the clipboard automatically

## Run jar file:
`java -jar app.jar`

## Commands
### Close
`close`

Closes the application

### Build
`build x y z [x y z]*`

This will create a fridge environment based on the dimensions used. The command will output relations between position objects, object declarations and sturdiness. Each triplet of positions represents a shelf. the hand object and necessary predicate are also printed.

### Item
`item ITEM_CLASS [orientation | orientation item_name]`

This will create an item of type ITEM_CLASS, on the provided orientation if provided, with the item_name provided if provided.
If item_name is not provided the 'item' is used as an item name. The constant object orientation assingments are also printed up to the max orientation the provided item class has. ITEM_CLASS can be anything from {ONE_ONE_ONE,ONE_ONE_THREE,ONE_ONE_TWO,ONE_TWO_THREE,ONE_TWO_TWO,TWO_TWO_TWO}. Orienation can be anything from {0..5}. 
If the orientation is not supported by the ITEM_CLASS used no orientation assignment is printed
Every item printed with this command is set to be in the bag

