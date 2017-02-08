(ns ovo.core-test
  (:require [clojure.test :refer :all]
            [ovo.core :refer :all]
            [schema.core :as s]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)
