(ns numerimap.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [numerimap.core :as num]))

(deftest sanity
  (testing "Sanity test."
    (is (= 5 (+ 2 3)))))

(deftest num-ops
  (testing "Unary operations"
    (is (= 1 (num/m-min {:a 1 :b 2})))
    (is (= 3 (num/m-sum {:a 1 :b 2})))
    (is (= [:a :b :b :c :c :c]
           (num/m-enumerate {:a 1 :b 2 :c 3}))))

  (testing "Add"
    (is (= {:a 4 :b 6}
           (num/m-add {:a 1 :b 2} {:a 3 :b 4})))
    (is (= {:a 9 :b 12}
           (num/m-add {:a 1 :b 2} {:a 3 :b 4} {:a 5 :b 6})))
    (is (= {:a 4 :b 6 :c 1}
           (num/m-add {:a 1 :b 2} {:a 3 :b 4 :c 1}))))

  (testing "Subtract"
    (is (= {:a 2 :b 2}
           (num/m-sub {:a 3 :b 4} {:a 1 :b 2})))))

;; The End
