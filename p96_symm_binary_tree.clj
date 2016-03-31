;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 96
;;
;; Let us define a binary tree as "symmetric" if the left half of the tree
;; is the mirror image of the right half of the tree.  Write a predicate to
;; determine whether or not a given binary tree is symmetric.
;; See problem 95 for a reminder of the tree representation we're using.

;; example:
;;                r
;;         a            a
;;     c      d       d    c
;;  e   f   g   h   h  g  f  e

(defn get-value [node]
  (first node))

(defn get-left [node]
  (second node))

(defn get-right [node]
  (last node))

(defn symmetric-branches? [left right]
   (cond
     (and (nil? left) (nil? right)) true
     (and (= (get-value left) (get-value right))
          (symmetric-branches? (get-left left) (get-right right))
          (symmetric-branches? (get-right left) (get-left right))) true
     :else false))

(defn sym-binary-tree? [t]
  (symmetric-branches? (get-left t) (get-right t)))

(and
 (= (sym-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
    false)

 (= (sym-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [6 nil nil] nil]] nil]])
    false)


 (= (sym-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
    true)

 (= (sym-binary-tree? '(:a (:b nil nil) (:b nil nil))) true)

 (= (sym-binary-tree? '(:a (:b nil nil) nil)) false)

 (= (sym-binary-tree? '(:a (:b nil nil) (:c nil nil))) false))
