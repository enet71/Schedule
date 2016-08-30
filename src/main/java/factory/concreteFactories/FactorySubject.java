package factory.concreteFactories;

import factory.FactoryDB;
import factory.abstractProducts.Create;
import factory.abstractProducts.Edit;
import factory.abstractProducts.Remove;
import factory.abstractProducts.Select;
import factory.products.subject.CreateSubject;
import factory.products.subject.EditSubject;
import factory.products.subject.RemoveSubject;
import factory.products.subject.SelectSubject;

public class FactorySubject implements FactoryDB{
    public Create tableCreate() {
        return new CreateSubject();
    }

    public Edit tableEdit() {
        return new EditSubject();
    }

    public Remove tableRemove() {
        return new RemoveSubject();
    }

    public Select tableSelect() {
        return new SelectSubject();
    }
}
