(defproject ovo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha8"]
                 [org.clojure/math.numeric-tower "0.0.4"]
                 [prismatic/schema "1.1.2"]]
  :main ^:skip-aot ovo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
