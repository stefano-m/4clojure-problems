;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 67
;;
;; Write a function which returns the first x
;; number of prime numbers.

;; Not very efficient, but OK for numbers that are not too large.
;;  https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
;; is probably a better algorithm to implement... maybe later.
(defn is-prime? [x]
  (empty? (filter #(zero? (rem x %)) (range 2 x))))

(defn nth-primes [n]
  (take n (filter is-prime? (iterate inc 2))))

(and
 (= (nth-primes 2) [2 3])

 (= (nth-primes 5) [2 3 5 7 11])

 (= (last (nth-primes 100)) 541))
