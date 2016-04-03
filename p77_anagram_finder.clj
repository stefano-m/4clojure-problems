;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 77

;; Write a function which finds all the anagrams in a vector of words.
;; A word x is an anagram of word y if all the letters in x can be rearranged
;; in a different order to form y.  Your function should return a set of sets,
;; where each sub-set is a group of words which are anagrams of each other.
;; Each sub-set should have at least two words.  Words without any anagrams
;; should not be included in the result.

(defn anagrams [xs]
  (reduce (fn [acc elem]
            (conj acc (set elem)))
          #{}
          (filter #(< 1 (count %))
                  (vals (group-by sort xs)))))

(and
 (= (anagrams ["meat" "mat" "team" "mate" "eat"])
    #{#{"meat" "team" "mate"}})

 (= (anagrams ["veer" "lake" "item" "kale" "mite" "ever"])
    #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))
