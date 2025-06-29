WEEK 4 reflections

I was impressed with my self for the confidence to catch a mistake and take initiative to voice that mistake publicly !!!!!!


Both my `DoubleLinkedList` and Professor Leo’s version share the same structure and core intentions:

- We both use `Node` objects with `next` and `previous` pointers for doubly linked list behavior.
- Our classes both implement `Comparable<DoubleLinkedList>` and override `toString()`.
- Constructors, field names, and method names like `add(Node)` and `add(String)` follow the same pattern.
- Our `Node` classes are completely identical — same fields, methods, and comments — which makes sense, since it was likely provided as base code.

## Differences

This time, I went further than the professor's skeleton implementation:

- I **completed** the `add(Node)` method to include backward linkage using `setPrevious()`, which was required by the assignment.
- I added a **`size` field** to track the number of nodes, and used it in the `compareTo()` method to compare list sizes.
- I implemented **`add(String)`** by creating a new node and reusing the existing `add(Node)` method.
- My `compareTo()` method compares by list size first, then by name lexicographically — his version just returns a dummy number.
  

## Reflection

I can feel myself writing code more confidently. I'm reusing methods, avoiding redundancy, and thinking about how each part fits into the larger structure. I didn’t just code until it “worked” — I wrote something that follows the design logic we’re learning in class.

The way I tracked `size` and reused `add(Node)` in `add(String)` felt clean and intentional. I still need to finish `indexOf()`, `contains()`, and the `size()` method, but the base is solid. This project also reminded me how much more readable and maintainable code is when everything is modular.

## General Thoughts

This class continues to push me. I still second-guess myself sometimes, but I notice I’m debugging faster and writing more deliberately. I also will restate I felt like a winner for actively catching mistakes!!!!!! I’m growing through the repetition and the structure. I’ll make sure to finish the remaining methods and start reviewing for the exam. I want to go into it not just hoping I understand things but knowing..... I just feel very stretched at this stage of the summer.
— Julia