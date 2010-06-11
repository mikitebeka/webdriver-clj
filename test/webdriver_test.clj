(ns webdriver-test
  (:refer-clojure :exclude [get])
  (:use [webdriver] :reload-all)
  (:use [clojure.test]))


(deftest test-google
  []
  (let [driver (webdriver/new-driver :firefox)]
    (webdriver/get driver "http://www.yahoo.com")
    (let [elem (webdriver/find-element driver (webdriver/by-name "p"))]
      (webdriver/send-keys elem "Sauce Labs\n")
      (let [results (webdriver/find-element driver (webdriver/by-id "results"))
            ok (.contains (webdriver/text results) "Sauce Labs")]
        (webdriver/quit driver)
        (is ok true)))))

