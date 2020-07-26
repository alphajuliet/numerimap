# numerimap

This library handles maps with numeric values, e.g. `{:a 1 :b 2}` that can be manipulated mathematically.

## Usage

```
(m-sum {:a 1 :b 2}) => 3
(m-add {:a 1 :b 2} {:a 3 :b 4}) => {:a 4 :b 6}
```

The other functions should be more or less obvious.

## Unary functions

* `(m-sum m)`: sum the values in the map
* `(m-apply f m)`: apply a function to the sequence of map values
* `(m-map f m)`: map a function over the map values

## Binary functions

* `(m-dot m1 m2)`: dot product
 
## n-ary functions

* `(m-add m1 m2...)`: add two or more maps
* `(m-sub m2 m2...)`: subtract
* `(m-mul m1 m2)`: pairwise multiplication

For operations on multiple maps, two combining functions are defined: `m-union` and `m-intersection` that determine which keys end up in the output as well as the function. Addition uses union, and multiplication uses intersection.

```
(m-add {:a 1 :b 2} {:a 4 :b 5 :c 6}) => {:a 5 :b 7 :c 6}
(m-mul {:a 1 :b 2} {:a 3 :b 4 :c 5}) => {:a 3 :b 8}
```

`m-add` and `m-mul` are defined respectively as `(partial m-union +)` and `(partial m-intersection *)`. You can define your own functions in a similar way. Note that `m-intersection` only operates on two maps right now. 

## Map packing

There are also two functions for packing and unpacking numeric maps as counts.

```
(m-enumerate {:a 1 :b 2 :c 3}) => [:a :b :b :c :c :c]
(m-collect [:b :c :a :c :b :c]) => {:a 1 :b 2 :c 3}
```

## License

Copyright © 2020 Andrew Joyner
MIT Licence. See LICENSE for details.
