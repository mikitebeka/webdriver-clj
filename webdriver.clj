; FIXME: This does not work
; (import '(java.io File))
; (add-classpath (str 
;                  "file://" 
;                  (.getCanonicalPath (new File ".")) 
;                  "webdriver-all.jar"))
(ns #^{:author "Miki Tebeka <miki.tebeka@gmail.com>"
       :doc "WebDriver support for Clojure" }
  webdriver
  (:refer-clojure :exclude [get])
  (:import [org.openqa.selenium By WebDriver WebElement]
           [org.openqa.selenium.firefox FirefoxDriver]
           [org.openqa.selenium.ie InternetExplorerDriver]))

(def *drivers* {
      :firefox FirefoxDriver
      :ie InternetExplorerDriver })
               
(defn new-driver
  "create new driver"
  [browser]
  (.newInstance (*drivers* browser)))

(defn get
  [driver url]
  (.get driver url))

(defn current-url
  [driver]
  (.getCurrentUrl driver))

(defn title
  [driver]
  (.getTitle driver))

; FIXME
(defn find-elements
  [driver]
  [])

; FIXME
(defn find-element
  [driver]
  [])

(defn page-source
  [driver]
  (.getPageSource driver))

(defn close
  [driver]
  (.close driver))

(defn quit
  [driver]
  (.quit driver))

; FIXME
(defn window-handles
  [driver]
  (into #{} (.getWindowHandles driver)))

(defn window-handle
  [driver]
  (.getWindowHandle driver))

(def driver (new-driver :firefox))
(get driver "http://google.com")
;(quit driver)

;(System/exit 0)
