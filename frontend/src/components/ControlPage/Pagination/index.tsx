import React from "react";
import { Fragment } from "react";
import { PersonPage } from "../../../types/person";
import icon00 from "../svg/arrow_left-pag.svg";
import icon01 from "../svg/arrow_right-pag.svg";

type Props = {
  page: PersonPage;
  onChange: Function;
};

const Pagination = ({ page, onChange }: Props) => {
  const stylePageRight = {
    lineHeight: "16px",
    textAlign: "right",
    marginTop: "5px",
    marginRight: "5px",
    marginBottom: "5px",
  } as React.CSSProperties;
  return (
    <Fragment>
      <div
        className="blog-pagination property-pagination "
        style={stylePageRight}
      >
        <button disabled={page.first} onClick={() => onChange(page.number - 1)}>
          <img src={icon00} alt="Left" />
        </button>

        <button>{page.number + 1}</button>

        <a
          href="/#"
          onClick={(e) => {
            e.preventDefault();
          }}
        >
          de
        </a>

        <button
          disabled={page.last}
          onClick={() => onChange(page.totalPages - 1)}
        >
          {page.totalPages}
        </button>

        <button disabled={page.last} onClick={() => onChange(page.number + 1)}>
          <img src={icon01} alt="Rigth" />
        </button>
      </div>
    </Fragment>
  );
};
export default Pagination;
