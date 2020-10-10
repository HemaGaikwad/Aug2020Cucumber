#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@sampleTag
Feature: Employee
  I want to use this template for my feature file
Background:
Given Application should be launched on browser

#Basic script example. No data passing
@smoke
Scenario: Employee Form
Given Application should be up and running
When Enter Employee Details
Then Click on Submit

#Example for parameterization. Passing data in scripts only
#@smoke
#Scenario: Employee Form Parameterized
#Given Application should be up and running
#When Enter Employee Details "Dab" "Andy"
#Then Click on Submit
#
#Example for Scenario Outline with Examples. Passing data with example Keywords
#
#@smoke
#Scenario Outline: Employee Form Outline Examples
#Given Application should be launched on browser
#When Enter Employee Details "<First Name>" "<Last Name>"
#Then Click on Submit
#Examples:
#|First Name |Last Name |
#|David |John |
#|Dab |Andy |
#
#Example for using Datatable
#
#@smoke
#Scenario: Employee Form Datatable
#Given Application should be launched on browser
#When Enter Employee Information Details
#|First Name |Last Name |
#|David |John |
#Then Click on Submit
