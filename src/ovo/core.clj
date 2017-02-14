(ns ovo.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :refer [expt]]
            [schema.core :as s]
            [medley.core :refer :all]))

(defn- year-month
  [string-date]
  (->> string-date
      (take 6)
      (apply str)))

(defn- data->map
  [input]
  {
   :date (first (keys input))
   :consumption (first (vals input))
   }
  )

(defn- total-consumption
  [daily-consumptions]
  (->> daily-consumptions
       (map :consumption)
       (apply +)))

(defn get-month-sum
  [input]
  (->> input
       (map data->map)
       (group-by (comp year-month :date))
       (map-vals total-consumption)))
