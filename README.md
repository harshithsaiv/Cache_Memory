# Cache Implementation in Java

This repository contains a Java implementation of a basic cache system.

Problem Statement:
Design a 4-way set associative memory with page size of 4K for a computer with main memory size of 4G. The CPU has data width of 32 bytes and Cacheline is same as the CPU data width. you can use any software language you prefer to code the 4-way set associative cache controller. 

Key features:

    Cache structure: 4-way set-associative cache with 32 sets
    Memory representation: Uses LinkedHashMaps for both cache and main memory
    Address mapping: Implements logic for converting page and set numbers to 32-bit hexadecimal addresses
    Cache operations:
        Cache checking for data retrieval

Demonstration:

    CacheController.java offers a simple demonstration of cache usage.
        Initializes a limited main memory with sample data
        Takes user input for page and set numbers
        Converts input to a hexadecimal address
        Checks for data in the cache, indicating hit or miss

Upcoming enhancements:

    Complete cache insertion and eviction logic
    Additional cache operations (e.g., replacement policies, write-back/write-through strategies)
    Performance analysis and optimization

Contributions are welcome:

    Fork the repository and submit pull requests for enhancements or bug fixes.
    Provide feedback and suggestions through issues.

To run the code:

    Clone the repository.
    Compile using a Java compiler: javac CacheController.java
    Run the main class: java CacheController

License: MIT: https://opensource.org/licenses/MIT
