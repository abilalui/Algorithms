

Rod-Cutting Problem: This is the implementation of the rod_cutting algorithm taken from
                     Introduction to Algorithms, Third Edition By Thomas H. Cormen,
                     Charles E. Leiserson, Ronald L. Rivest and Clifford Stein

Problem:
    Given:
        We are given a rod of n inches long. We are also given different prices of different 
        lengths k of the rod, where k is (1 <= k <= n). 

    Goal:
        Our goal is to find the combination of k lengths to maximize our rod selling price. 

Approach: 
    The general approach to this problem is to divide the problem to sub problems such
    that each sub problem is optimized. We divide the rod into pieces so that each piece
    generate maximum revenue/price. For better time complexity, we approach our solution
    using dynamic programming. That means we record all our solved sub-problems so in case
    of need we refer back to them and not recompute them, which can substantially reduce 
    the time complexity. 

    