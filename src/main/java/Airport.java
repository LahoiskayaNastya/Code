import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {

	private List<? extends Plane> planes;

	public Airport(List<Plane> planes) {

	}

	public List<PassengerPlane> getPassengerPlane() {
		List<PassengerPlane> passengerPlane = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof PassengerPlane) {
				passengerPlane.add((PassengerPlane) plane);}
		}
		return passengerPlane;
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		List<MilitaryPlane> militaryPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof MilitaryPlane) {
				militaryPlanes.add((MilitaryPlane) plane);
			}
		}
		return militaryPlanes;
	}

	public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
		List<PassengerPlane> passengerPlanes = getPassengerPlane();
		PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
		for (int i = 0; i < passengerPlanes.size(); i++) {
			if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
				planeWithMaxCapacity = passengerPlanes.get(i);
			}
		}

		return planeWithMaxCapacity;
	}

	public List<MilitaryPlane> getTransportMilitaryPlanes() {
		List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
		List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
		for (int i = 0; i < militaryPlanes.size(); i++) {
			MilitaryPlane plane = militaryPlanes.get(i);
			if (plane.getType() == MilitaryType.TRANSPORT) {//заменить на иквелз
				transportMilitaryPlanes.add(plane);
			}
		}
		return transportMilitaryPlanes;
	}

	public List<MilitaryPlane> getBomberMilitaryPlanes() {
		List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
		List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
		for (int i = 0; i < militaryPlanes.size(); i++) {
			if (militaryPlanes.get(i).getType() == MilitaryType.BOMBER) {
				bomberMilitaryPlanes.add(militaryPlanes.get(i));
			}
		}
		return bomberMilitaryPlanes;

	}

	public List<ExperimentalPlane> getExperimentalPlanes() {
		List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof ExperimentalPlane) {
				experimentalPlanes.add((ExperimentalPlane) plane);
			}
		}
		return experimentalPlanes;
	}

	public Airport sortByMaxDistance() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
			}
		});
		return this;
	}

	/**
	 * Sorts by max speed
	 *
	 * @return Airport
	 */
	public Airport sortByMaxSpeed() {

		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {

				return o1.getMS() - o2.getMS();
			}
		});
		return this;
	}

	public Airport sortByMaxLoadCapacity() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {

				return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
			}
		});
		return this;
	}

	public List<? extends Plane> getPlanes() {

		return planes;
	}

	private void print(Collection<? extends Plane> collection) {
		for (Plane plane : collection) {
			System.out.println(plane);
		}
	}

	@Override
	public String toString() {

		return "Airport{" + "planes=" + planes.toString() + '}';
	}
}
