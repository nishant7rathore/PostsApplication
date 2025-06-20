import React from "react";
import { PostType } from "../types";

const Post = ({
  post,
  setSelectedPost,
}: {
  post: PostType;
  setSelectedPost: (post: PostType | null) => void;
}) => {
  return (
    <div
      style={{
        border: "1px solid #ccc",
        borderRadius: "5px",
        padding: "0px 20px",
        cursor: "pointer",
        userSelect: "none",
      }}
      onClick={() => setSelectedPost(post)}
    >
      <h2
        style={{
          fontSize: "1.5em",
          fontWeight: "700",
          marginBottom: "10px",
        }}
      >
        {post.title}
      </h2>
      <p style={{ marginBottom: "10px" }}>{post.content}</p>
      <p>
        <strong>Author:</strong> {post.author}
      </p>
      <p>
        <strong>Posted on:</strong>{" "}
        {new Date(post.createdAt).toLocaleDateString()}
      </p>
      <p>
        <strong>User preview:</strong>{" "}
        {post.userPreview.map((username) => username).join(", ")}
      </p>
    </div>
  );
};

export default Post;
