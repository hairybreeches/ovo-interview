(ns ovo.core-test
  (:require [clojure.test :refer :all]
            [ovo.core :refer :all]
            [schema.core :as s]
            [ovo.data :refer [input]]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)

(deftest find-month-usages
  (is (= '({:year-month "201512", :usage 30.1} {:year-month "201601", :usage 26.9})
         (get-month-usage input))))