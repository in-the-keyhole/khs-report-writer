Java PDF column report writer  [![Build Status](https://secure.travis-ci.org/in-the-keyhole/khs-report-writer.png?branch=master)](http://travis-ci.org/in-the-keyhole/khs-report-writer)
===========

Description
===========
Create column based PDF reports. It's lightweight and fast. If you need desktop published 
reports, then something like Jasper reports would be better.  If you need to create a column
based report with grouping, totaling, and sub totaling, then this framework will help you out. 

Examples
========
Test folder has a couple of JUNIT tests that can be run to produce example reports

Installation
============
Grab the khs-report-writer-X.X.jar in this project and put in your class path

or using maven

Download and install using following mvn command 

     mvn install 

and add the following depedency to your POM.xml 
     <dependency>
       <groupId>com.keyholesoftware</groupId>
       <artifactId>khs-report-writer</artifactId>
       <version>1.0</version>
     </dependency>

Usage Example
=============

// output writer
ReportPDFWriter writer = new ReportPDFWriter();
writer.setOut(new FileOutputStream(new File(new URI("file:/users/dpitt/stocks.pdf"))));

// create processor with factory and iterator
// create processor with a ReportFactory and ReportIterator
// Factory describes report format (columns,headings) 
// Iterator turns report data into frameworks row and column type

ReportProcessor processor = new ReportProcessor(new StockQuoteReportFactory(), new StockReportIterator());
processor.writer = writer;
processor.process();

















