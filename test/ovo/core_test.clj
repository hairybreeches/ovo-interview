(ns ovo.core-test
  (:require [clojure.test :refer :all]
            [ovo.core :refer :all]
            [schema.core :as s]
            [ovo.data :refer [input]]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)

(deftest sums-are-right
  (is (= {
          "201512" 60.4
          "201601" 305.4
          "201602" 130.0
          }
         (get-month-sum input)
         )))