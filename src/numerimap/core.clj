;; numerimap/core.clj
;; AndrewJ 2020-07-25

(ns numerimap.core)

(defn m-apply
  "Apply a unary function to the values of the map."
  [f m]
  (apply f (vals m)))

(def m-min (partial m-apply min))
(def m-sum (partial m-apply +))

(def m-union merge-with)

(def m-add (partial m-union +))
(def m-sub (partial m-union -))
;; (def m-mul (partial m-union *))

(defn m-enumerate
  "For each pair [k v] in a numeric map, add v copies of k, and concatenate into a single list."
  [h]
  (reduce-kv
   (fn [m k v]
     (into m (repeat v k))) [] h))

(defn m-collect
  "Collect a list into a numeric map of counts."
  [lst]
  (into {} (map (fn [[k v]] [k (count v)])
                (group-by identity lst))))

; From Racket...
;(defn map-intersection [f h1 h2]
;         ;#:combine/key [combine/key (λ (k x y) (* x y))]
;         ;h1 h2)
;  (for/map ([k (in-list (intersection (map-keys h1) (map-keys h2)))])
;            (values k (combine/key k (map-ref h1 k) (map-ref h2 k)))))

;(define (map-union
;         #:combine [combine #f]
;         #:combine/key [combine/key
;                        (if combine
;                          (lambda (k x y) (combine x y))
;                          (map-duplicate-error 'map-union))]
;         one . rest)
;  (for*/fold ([one one]) ([two (in-list rest)] [(k v) (in-map two)])
;    (map-set one k (if (map-has-key? one k)
;                        (combine/key k (map-ref one k) v)
;                        v))))

;; The End
