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
   :meter-read (first (vals input))
   }
  )

(defn- total-consumption
  [daily-consumptions]
  (->> daily-consumptions
       (map :meter-read)
       (apply +)))

(defn month-start-readings
  [input]
  (->> input
       (map data->map)
       (partition-by (comp year-month :date))
       (map first)
       (map #(assoc % :year-month (year-month (:date %))))
       ;(group-by (comp year-month :date))
       ;(map-vals first)
       ;(map-vals :meter-read)))
       ))

(defn current-month-consumption
  [next-month current-month]
  {
   :year-month (:year-month current-month)
   :usage (- (:meter-read next-month) (:meter-read current-month))
   }
  )

(defn get-month-usage
  [input]
  (let [starts (month-start-readings input)]
    (->> starts
         (map current-month-consumption (drop 1 starts))
    )))
