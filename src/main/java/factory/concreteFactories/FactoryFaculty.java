package factory.concreteFactories;

import factory.FactoryDB;
import factory.abstractProducts.Create;
import factory.abstractProducts.Edit;
import factory.abstractProducts.Remove;
import factory.abstractProducts.Select;
import factory.products.faculty.CreateFaculty;
import factory.products.faculty.EditFaculty;
import factory.products.faculty.RemoveFaculty;
import factory.products.faculty.SelectFaculty;

public class FactoryFaculty implements FactoryDB {
    public Create tableCreate() {
        return new CreateFaculty();
    }

    public Edit tableEdit() {
        return new EditFaculty();
    }

    public Remove tableRemove() {
        return new RemoveFaculty();
    }

    public Select tableSelect() {
        return new SelectFaculty();
    }
}
