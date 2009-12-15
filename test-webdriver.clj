(require 'webdriver)

(defn test-google
  []
  (let [driver (webdriver/new-driver :firefox)]
    (webdriver/get driver "http://google.com")
    (let [elem (webdriver/find-element driver (webdriver/by-name "q"))]
      (webdriver/send-keys elem "Sauce Labs\n")
      (webdriver/quit driver))))

(test-google)
(System/exit 0)
