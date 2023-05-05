function CategoryDetails(props: any) {
  const { id, code, name, description } = props.props;
  return (
    <div className="w-2/5 text-left ml-80">
      <div className="flex">
        <span className="w-2/5">id :</span>
        <span className="w-3/5">{id}</span>
      </div>
      <div className="flex">
        <span className="w-2/5">code :</span>
        <span className="w-3/5">{code}</span>
      </div>
      <div className="flex">
        <span className="w-2/5">name :</span>
        <span className="w-3/5">{name}</span>
      </div>
      <div className="flex">
        <span className="w-2/5">description :</span>
        <span className="w-3/5">{description}</span>
      </div>
    </div>
  );
}

export default CategoryDetails;
