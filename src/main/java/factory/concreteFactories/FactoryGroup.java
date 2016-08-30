package factory.concreteFactories;

import factory.*;
import factory.abstractProducts.Create;
import factory.abstractProducts.Edit;
import factory.abstractProducts.Remove;
import factory.abstractProducts.Select;
import factory.products.group.CreateGroup;
import factory.products.group.EditGroup;
import factory.products.group.RemoveGroup;
import factory.products.group.SelectGroup;

public class FactoryGroup implements FactoryDB {

    public Create tableCreate() {
        return new CreateGroup();
    }

    public Edit tableEdit() {
        return new EditGroup();
    }

    public Remove tableRemove() {
        return new RemoveGroup();
    }

    public Select tableSelect() {
        return new SelectGroup();
    }
}
