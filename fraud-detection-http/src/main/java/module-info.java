/**
 * @author claudioed on 2019-02-02.
 * Project fraud-detection-http
 */
open module fraud.detection.http {

  requires spring.beans;
  requires spring.core;
  requires spring.context;
  requires spring.web;
  requires spring.boot;
  requires spring.boot.autoconfigure;
  requires spring.boot.starter.reactor.netty;
  requires jdk.unsupported;

}