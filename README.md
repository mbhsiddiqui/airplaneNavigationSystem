# Airplan Navigation System
Implemented the following design patterns:  Proxy, Observer, Façade, and Strategy 

## `NavigationFacade`
The NavigationFacade class implements the Facade design pattern. It provides a unified interface (the getCoordinates method) to a set of interfaces in the subsystem (such as GPS receivers). This pattern simplifies the client interface and abstracts the complexities involved in getting the GPS coordinates.

## `NavProxy`
The NavProxy class implements the Proxy design pattern. The Proxy provides an interface identical to the Real Subject (NavigationFacade) and controls access to it. In this context, the Proxy is used to simplify the interface of NavigationFacade and control the access to its methods.

## `ICompareCoordsStrategy`
The ICompareCoordsStrategy interface and its implementations (FirstIsBest and TwoThreeVoting) represent the Strategy design pattern. The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern allows the algorithm to vary independently from the clients that use it. In this case, it allows varying the method of comparing coordinates.

## `IControlActuator Interface, AileronActuator, ElevatorActuator, and RudderActuator (in the controlSurfacesModule package)`
These classes also represent the Strategy design pattern, similar to the comparison strategies. The IControlActuator interface defines a contract for updating control surfaces, and the different implementations provide specific strategies to do so.

## `GPSDataSubject, IControlActuator Interface, AileronActuator, ElevatorActuator, and RudderActuator (in the controlSurfacesModule package)`
This module is implements the Observer design pattern. This pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. The GPSDataSubject maintains a list of observers and notifies them when the GPS data changes.
